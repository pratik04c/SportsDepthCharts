package com.sports.depthchart.converter;

import com.sports.depthchart.model.PlayerModel;

import org.springframework.stereotype.Component;

import com.sports.depthchart.entity.LeaguePosition;
import com.sports.depthchart.entity.Player;

@Component
public class PlayerConverter {
	public Player convertPlayer(PlayerModel playerModel) {
		return new Player(playerModel.getPlayerId(), playerModel.getName());		
	}
	public LeaguePosition convertPosition(PlayerModel playerModel) {
		return new LeaguePosition(playerModel.getLeague(), playerModel.getPosition());		
	}
}
