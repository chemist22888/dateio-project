package cz.dateio.dateio;

import cz.dateio.dateio.exception.ClientNotFoundException;
import cz.dateio.dateio.exception.OfferNotFoundException;
import cz.dateio.dateio.model.domain.Client;
import cz.dateio.dateio.model.domain.Offer;
import cz.dateio.dateio.model.domain.OfferWatch;
import cz.dateio.dateio.model.dto.OfferWatchDto;
import cz.dateio.dateio.repository.ClientRepository;
import cz.dateio.dateio.repository.OfferRepository;
import cz.dateio.dateio.repository.OfferWatchRepository;
import cz.dateio.dateio.service.ClientService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
//@Sql(scripts = {})
public class ClientServiceTest {
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    OfferRepository offerRepository;
    @Autowired
    OfferWatchRepository offerWatchRepository;
    @Autowired
    ClientService clientService;



    @Test
    public void testCorrect() throws Exception {
        OfferWatchDto res = clientService.addOfferWatch(1L,2L);

        Assert.assertEquals(Long.valueOf(1),res.getClientId());
        Assert.assertEquals(Long.valueOf(2),res.getOfferId());
        Assert.assertEquals(1,offerWatchRepository.findAll().size());

    }

    @Test(expected = ClientNotFoundException.class)
    public void testWrongClientId() throws Exception {
        clientService.addOfferWatch(300L,2L);
    }

    @Test(expected = OfferNotFoundException.class)
    public void testWrongOfferId() throws Exception {
        clientService.addOfferWatch(2l,200L);
    }

}
