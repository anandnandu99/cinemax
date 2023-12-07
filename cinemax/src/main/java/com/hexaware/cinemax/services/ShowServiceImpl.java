package com.hexaware.cinemax.services;

import com.hexaware.cinemax.dto.ShowDTO;
import com.hexaware.cinemax.entities.Show;
import com.hexaware.cinemax.entities.Theatre;
import com.hexaware.cinemax.entities.Movie;
import com.hexaware.cinemax.repositories.ShowRepository;
import com.hexaware.cinemax.repositories.TheatreRepository;
import com.hexaware.cinemax.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShowServiceImpl implements IShowService {

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private TheatreRepository theatreRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public ShowDTO addShow(ShowDTO showDTO) {
        Show newShow = convertToEntity(showDTO);
        Show savedShow = showRepository.save(newShow);
        return convertToDTO(savedShow);
    }

    @Override
    public List<ShowDTO> getAllShows() {
        return showRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void removeShowById(int id) {
        showRepository.deleteById(id);
    }

    // Other methods for updating shows, retrieving shows by name, etc.

    private ShowDTO convertToDTO(Show show) {
        ShowDTO showDTO = new ShowDTO();
        showDTO.setId(show.getId());
        showDTO.setShowName(show.getShowName());
        showDTO.setShowDateTime(show.getShowDateTime());
        showDTO.setTheatreName(show.getTheatre().getName());
        showDTO.setMovieName(show.getMovie().getTitle());
        return showDTO;
    }

    private Show convertToEntity(ShowDTO showDTO) {
        Show show = new Show();
        show.setShowName(showDTO.getShowName());
        show.setShowDateTime(showDTO.getShowDateTime());

        // Fetch Theatre and Movie entities by name from their repositories
        Theatre theatre = theatreRepository.findByName(showDTO.getTheatreName());
        Movie movie = movieRepository.findByTitle(showDTO.getMovieName());

        show.setTheatre(theatre);
        show.setMovie(movie);
        return show;
    }
}
