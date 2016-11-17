package com.travelsupermarket.latedeals.health;

import com.codahale.metrics.health.HealthCheck.Result;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class ReferenceDataElasticsearchHealthCheckTest {

    private LateDealsHealthCheck check;

    @Before
    public void before() {
        check = new LateDealsHealthCheck();
    }

    @Test
    public void testCheck() throws Exception {
        Result result = check.check();
        assertThat(result.isHealthy(), is(true));
    }
}
