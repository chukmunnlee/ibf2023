package ibf2023.paf.day23.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ibf2023.paf.day23.models.BoardgameSummary;
import ibf2023.paf.day23.repositories.BoardgameRepository;

@Service
public class BoardgameService {

   @Autowired
   private BoardgameRepository boardgameRepo;

   public List<BoardgameSummary> getBoardgameStatisticsByName(String name) {
      return boardgameRepo.getBoardgameStatistics("%" + name + "%");
   }
}
