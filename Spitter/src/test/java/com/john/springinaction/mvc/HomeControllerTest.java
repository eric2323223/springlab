package com.john.springinaction.mvc;

import com.john.springinaction.domain.Spittle;
import com.john.springinaction.service.SpitterService;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.*;

/**
 * Created with IntelliJ IDEA.
 * User: eric
 * Date: 9/13/12
 * Time: 3:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class HomeControllerTest {
    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void shouldDisplayRecentSpittles() {
        List<Spittle> expectedSpittles = asList(new Spittle(), new Spittle(), new Spittle());
        SpitterService spitterService = mock(SpitterService.class);
        when(spitterService.getRecentSpittles(HomeController.DEFAULT_SPITTLES_PER_PAGE)).
                thenReturn(expectedSpittles);
        HomeController controller = new HomeController(spitterService);
        HashMap<String, Object> model = new HashMap<String, Object>();
        String viewName = controller.showHomePage(model);
        assertEquals("home", viewName);
        assertSame(expectedSpittles, model.get("spittles"));
        verify(spitterService, times(1)).getRecentSpittles(HomeController.DEFAULT_SPITTLES_PER_PAGE);
    }
}
