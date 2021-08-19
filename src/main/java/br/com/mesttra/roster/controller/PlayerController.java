package br.com.mesttra.roster.controller;

import br.com.mesttra.roster.dto.AvailabilityDTO;
import br.com.mesttra.roster.entity.Player;
import br.com.mesttra.roster.service.PlayerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/players")
public class PlayerController {

    PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping
    public Player addPlayer(@RequestBody Player player) {
        return playerService.addPlayer(player);
    }

    @GetMapping
    public List<Player> listPlayer() { return playerService.listPlayers();}

    @GetMapping(path = "/{id}")
    public Optional<Player> getPlayer(@PathVariable Long id) {
        return playerService.getPlayer(id);
    }

    @DeleteMapping(path = "/{id}")
    public String removePlayer(@PathVariable Long id) {
        return playerService.removePlayer(id);
    }

    @PatchMapping(path = "/{id}")
    public Player changePlayerAvailability(@PathVariable Long id, @RequestBody AvailabilityDTO availabilityDTO) {
        return playerService.changePlayerAvailability(id, availabilityDTO.isAvailable());
    }


}
