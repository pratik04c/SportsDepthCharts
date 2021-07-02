package com.sports.depthchart.test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.Test;
import com.sports.depthchart.entity.LeaguePosition;
import com.sports.depthchart.entity.Player;
import com.sports.depthchart.service.DepthChartService;
import com.sports.depthchart.service.DepthChartServiceImpl;

public class AddPlayerTest {

	DepthChartService service = new DepthChartServiceImpl();
	
	Player p1 = new Player(1, "Bob");
	Player p2 = new Player(2, "Alice");
	Player p3 = new Player(3, "Charlie");
	Player p4 = new Player(4, "Tom");
	
	LeaguePosition l1 = new LeaguePosition("NFL", "WR");
	LeaguePosition l2 = new LeaguePosition("NFL", "KR");
	LeaguePosition l3 = new LeaguePosition("MLB", "RP");

	@Test
	public void test() throws Exception {
		
		service.addPlayerToDepthChart(p1, l1, 0);
		assertThat(service.getFullDepthChart(), containsString("[NFL:WR] = [(ID=1, Name=Bob)]"));

		service.addPlayerToDepthChart(p2, l1, 1);
		assertThat(service.getFullDepthChart(), containsString("[NFL:WR] = [(ID=1, Name=Bob), (ID=2, Name=Alice)]"));
		
		service.addPlayerToDepthChart(p3, l1, 0);
		assertThat(service.getFullDepthChart(), containsString("[NFL:WR] = [(ID=3, Name=Charlie), (ID=1, Name=Bob), (ID=2, Name=Alice)]"));

		service.addPlayerToDepthChart(p4, l1);
		assertThat(service.getFullDepthChart(), containsString("[NFL:WR] = [(ID=3, Name=Charlie), (ID=1, Name=Bob), (ID=2, Name=Alice), (ID=4, Name=Tom)]"));
		
		service.addPlayerToDepthChart(p2, l2, 0);
		assertThat(service.getFullDepthChart(), containsString("[NFL:KR] = [(ID=2, Name=Alice)]"));
		
		service.addPlayerToDepthChart(p3, l3, 0);
		assertThat(service.getFullDepthChart(), containsString("[MLB:RP] = [(ID=3, Name=Charlie)]"));
		
		service.addPlayerToDepthChart(p4, l3, 0);		
		assertThat(service.getFullDepthChart(), containsString("[NFL:KR] = [(ID=2, Name=Alice)]"));
		assertThat(service.getFullDepthChart(), containsString("[MLB:RP] = [(ID=4, Name=Tom), (ID=3, Name=Charlie)]"));
		assertThat(service.getFullDepthChart(), containsString("[NFL:WR] = [(ID=3, Name=Charlie), (ID=1, Name=Bob), (ID=2, Name=Alice), (ID=4, Name=Tom)]"));
	}

}
