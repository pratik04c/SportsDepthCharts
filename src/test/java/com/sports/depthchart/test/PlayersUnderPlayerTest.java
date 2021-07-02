package com.sports.depthchart.test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.Test;
import com.sports.depthchart.entity.LeaguePosition;
import com.sports.depthchart.entity.Player;
import com.sports.depthchart.service.DepthChartService;
import com.sports.depthchart.service.DepthChartServiceImpl;

public class PlayersUnderPlayerTest {

	DepthChartService service = new DepthChartServiceImpl();
	
	Player p1 = new Player(1, "Bob");
	Player p2 = new Player(2, "Alice");
	Player p3 = new Player(3, "Charlie");
	Player p4 = new Player(4, "Tom");
	Player p5 = new Player(5, "Alex");
	Player p6 = new Player(6, "Matt");
	
	LeaguePosition l1 = new LeaguePosition("NFL", "WR");

	@Test
	public void test() throws Exception {
		
		service.addPlayerToDepthChart(p1, l1, 0);
		service.addPlayerToDepthChart(p2, l1, 1);
		service.addPlayerToDepthChart(p3, l1, 0);
		service.addPlayerToDepthChart(p4, l1);
		service.addPlayerToDepthChart(p5, l1, 2);
		service.addPlayerToDepthChart(p6, l1, 3);
		
		assertThat(service.getPlayersUnderPlayerInDepthChart(5, l1).toString(), containsString("[(ID=6, Name=Matt), (ID=2, Name=Alice), (ID=4, Name=Tom)]"));
		assertThat(service.getPlayersUnderPlayerInDepthChart(4, l1).toString(), containsString("[]"));
		assertThat(service.getPlayersUnderPlayerInDepthChart(7, l1).toString(), containsString("[]"));

		
	}

}
