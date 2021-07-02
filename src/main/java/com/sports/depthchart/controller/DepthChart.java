/*package com.sports.depthchart.controller;

import com.sports.depthchart.entity.LeaguePosition;
import com.sports.depthchart.entity.Player;
import com.sports.depthchart.service.DepthChartService;
import com.sports.depthchart.service.DepthChartServiceImpl;

public class DepthChart {

	public static void main(String[] args) throws Exception {
		
		DepthChartService service = new DepthChartServiceImpl();
		Player p1 = new Player(1, "Bob");
		Player p2 = new Player(2, "Alice");
		Player p3 = new Player(3, "Charlie");
		Player p4 = new Player(4, "Tom");
		Player p5 = new Player(5, "Alex");
		Player p6 = new Player(6, "Matt");
		
		LeaguePosition l1 = new LeaguePosition("NFL", "WR");
		LeaguePosition l11 = new LeaguePosition("NFL", "WR");
		LeaguePosition l2 = new LeaguePosition("NFL", "KR");
		LeaguePosition l3 = new LeaguePosition("MLB", "RP");
		
		service.addPlayerToDepthChart(p1, l1, 0);
		service.addPlayerToDepthChart(p2, l11, 0);
		service.addPlayerToDepthChart(p3, l1, 0);
		service.addPlayerToDepthChart(p4, l1);
		service.addPlayerToDepthChart(p5, l1, 2);
		service.addPlayerToDepthChart(p6, l1, 3);
		
		service.addPlayerToDepthChart(p2, l2, 0);
		
		service.addPlayerToDepthChart(p3, l3, 0);
		service.addPlayerToDepthChart(p4, l3, 0);
		
		System.out.println(service.getFullDepthChart());
		System.out.println(service.getPlayersUnderPlayerInDepthChart(5, l1));
		System.out.println(service.getPlayersUnderPlayerInDepthChart(4, l1));
		System.out.println(service.getPlayersUnderPlayerInDepthChart(7, l1));
		System.out.println(service.getFullDepthChart());
		System.out.println(service.getPlayersUnderPlayerInDepthChart(3, l1));

	}
	
	
	

}*/
