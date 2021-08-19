package br.com.mesttra.roster.service;

import br.com.mesttra.roster.entity.Player;
import br.com.mesttra.roster.repository.PlayerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PlayerService {

    PlayerRepository playerRepository;

    public Player addPlayer(Player player) {
        return playerRepository.save(player);
    }

    public List<Player> listPlayers() {
        return playerRepository.findAll();
    }

    public Optional<Player> getPlayer(Long playerId) {
        return playerRepository.findById(playerId);
    }

    public String removePlayer(Long playerId) {
        playerRepository.deleteById(playerId);
        return "Removido com sucesso";
    }

    @Transactional
    public Player changePlayerAvailability(Long playerId, boolean available) {

        Player player = playerRepository.getById(playerId);
        player.setAvailable(available);
        return playerRepository.save(player);

    }

    @Transactional
    public void makePlayerUnavailable(Long playerId) {

        Player player = playerRepository.getById(playerId);
        player.setAvailable(false);
        playerRepository.save(player);

    }
}
