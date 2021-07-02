package com.sports.depthchart.test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import com.sports.depthchart.entity.LeaguePosition;
import com.sports.depthchart.entity.Player;
import com.sports.depthchart.service.DepthChartService;
import com.sports.depthchart.service.DepthChartServiceImpl;

public class RemovePlayerTest {

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
		
		service.removePlayerFromDepthChart(3, l1);		
		assertThat(service.getFullDepthChart(), not(containsString("ID=3")));
		
		service.removePlayerFromDepthChart(4, l1);		
		assertThat(service.getFullDepthChart(), not(containsString("ID=4")));
		
		service.removePlayerFromDepthChart(5, l1);		
		assertThat(service.getFullDepthChart(), not(containsString("ID=5")));
		
		service.removePlayerFromDepthChart(7, l1);		
		assertThat(service.getFullDepthChart(), not(containsString("ID=7")));
		assertNull(service.removePlayerFromDepthChart(7, l1));
		
	}

}
