//package com.sentryc.marketplaces;
//
//import com.sentryc.marketplaces.constants.PageInput;
//import com.sentryc.marketplaces.constants.SellerFilter;
//import com.sentryc.marketplaces.constants.SellerSortBy;
//import com.sentryc.marketplaces.dto.ProducerSellerState;
//import com.sentryc.marketplaces.dto.RequestSellerDataPost;
//import com.sentryc.marketplaces.dto.SellerPagebleResponse;
//import com.sentryc.marketplaces.model.*;
//import com.sentryc.marketplaces.repos.MarketPlaceRepo;
//import com.sentryc.marketplaces.repos.ProducerRepo;
//import com.sentryc.marketplaces.repos.SellerInfoRepo;
//import com.sentryc.marketplaces.repos.SellerRepo;
//import com.sentryc.marketplaces.service.MarketPlaceService;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.List;
//import java.util.UUID;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.mockito.Mockito.when;
//
//@SpringBootTest
//class MarketplacesApplicationTests {
//
//    @Mock
//    private SellerRepo sellerRepo;
//
//    @Mock
//    private SellerInfoRepo sellerInfoRepo;
//
//    @Mock
//    private MarketPlaceRepo marketPlaceRepo;
//
//    @Mock
//    private ProducerRepo producerRepo;
//
//    @InjectMocks
//    private MarketPlaceService service;
//
//    void setUp() {
//        MockitoAnnotations.initMocks(this);
//    }
//
//    @Test
//    void getAllSellerData() {
//        UUID producerId = UUID.randomUUID();
//        UUID sellerId = UUID.randomUUID();
//        // Given
//        Seller seller = new Seller();
//        seller.setSellerInfo(new SellerInfo());
//        seller.getSellerInfo().setName("ExampleSeller");
//        seller.getSellerInfo().setExternalId("123");
//        seller.getSellerInfo().setMarketPlace(new MarketPlace());
//        seller.getSellerInfo().getMarketPlace().setId("XYZ");
//        seller.setProducer(new Producer());
//        seller.getProducer().setId(producerId);
//        seller.getProducer().setName("ExampleProducer");
//        seller.setState(State.REGULAR);
//        seller.setId(sellerId);
//
//        when(sellerRepo.findAll()).thenReturn(List.of(seller));
//
//        // When
//        RequestSellerDataPost sellerDataPost = new RequestSellerDataPost(
//                SellerFilter.EXTERNAL_ID,
//                new PageInput(1, 2),
//                SellerSortBy.ASC);
//        List<SellerPagebleResponse> result = service.getSellerData(sellerDataPost);
//
//        // Then
//        assertNotNull(result);
//        assertEquals(1, result.size());
//
//        SellerPagebleResponse response = result.get(0);
//        assertEquals("ExampleSeller", response.getSellerName());
//        assertEquals("123", response.getExternalId());
//        assertEquals("XYZ", response.getMarketPlaceId());
//
//        assertNotNull(response.getProducerSellerStates());
//        assertEquals(1, response.getProducerSellerStates().size());
//
//        ProducerSellerState producerSellerState = response.getProducerSellerStates().get(0);
//        assertEquals(producerId.toString(), producerSellerState.getProducerId());
//        assertEquals("ExampleProducer", producerSellerState.getProducerName());
//        assertEquals("REGULAR", producerSellerState.getState().toString());
//        assertEquals(sellerId.toString(), producerSellerState.getSellerId());
//    }
//}
