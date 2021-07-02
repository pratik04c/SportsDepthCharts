package com.sports.depthchart.controller;

import java.util.LinkedList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.sports.depthchart.converter.PlayerConverter;
import com.sports.depthchart.entity.Player;
import com.sports.depthchart.exception.IncorrectPositionDepthException;
import com.sports.depthchart.exception.PlayerNotAvailable;
import com.sports.depthchart.model.PlayerModel;
import com.sports.depthchart.service.DepthChartService;

@Controller
public class DepthChartController {
	
	@Autowired
	private DepthChartService service;
	
	@Autowired
	private PlayerConverter converter;
	
	@RequestMapping(value = "/addPlayer", method = RequestMethod.POST)
	public @ResponseBody LinkedList<Player> addPlayerToDepthChart(@RequestBody PlayerModel player) {
		LinkedList<Player> lstPlayer = null;
		if(player.getPositionDepth() != null) {
			lstPlayer = service.addPlayerToDepthChart(converter.convertPlayer(player), converter.convertPosition(player), player.getPositionDepth());
		} else {
			lstPlayer = service.addPlayerToDepthChart(converter.convertPlayer(player), converter.convertPosition(player));
		}
		if(lstPlayer != null) {
			return lstPlayer;
		} else {
			throw new IncorrectPositionDepthException("Incorrect Position Depth " + player.getPositionDepth());
		}
	}	
	
	@RequestMapping(value = "/removePlayer", method = RequestMethod.DELETE)
	public @ResponseBody Player removePlayerFromDepthChart(@RequestBody PlayerModel player) {
		Player rPlayer = service.removePlayerFromDepthChart(player.getPlayerId(), converter.convertPosition(player));
		if(rPlayer != null) {
			return rPlayer;
		} else {
			throw new PlayerNotAvailable("Player Not Available with Player ID " + player.getPlayerId());
		}
	}

	@RequestMapping(value = "/getPlayersUnderPlayer", method = RequestMethod.POST)
	public @ResponseBody LinkedList<Player> getPlayersUnderPlayerInDepthChart(@RequestBody PlayerModel player)
			throws Exception {
		return service.getPlayersUnderPlayerInDepthChart(player.getPlayerId(), converter.convertPosition(player));
	}

	@RequestMapping(value = "/getFullDepthChart", method = RequestMethod.GET)
	public @ResponseBody String getFullDepthChart() throws Exception {
		return service.getFullDepthChart();
	}
	 
	
	
	
}
