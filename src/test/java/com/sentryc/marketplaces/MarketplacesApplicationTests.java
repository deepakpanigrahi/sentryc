//package com.sentryc.marketplaces;
//
//import com.sentryc.marketplaces.dto.SellerPagebleResponse;
//import com.sentryc.marketplaces.dto.ProducerSellerState;
//import com.sentryc.marketplaces.model.*;
//import com.sentryc.marketplaces.repos.MarketPlaceRepo;
//import com.sentryc.marketplaces.repos.ProducerRepo;
//import com.sentryc.marketplaces.repos.SellerInfoRepo;
//import com.sentryc.marketplaces.repos.SellerRepo;
//import com.sentryc.marketplaces.service.SellerService;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Sort;
//
//import java.util.List;
//import java.util.UUID;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.ArgumentMatchers.anyString;
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
//    private SellerService service;
//
//    void setUp() {
//        MockitoAnnotations.initMocks(this);
//    }
//
//    @Test
//    void findByPageAndSize() {
//        when(sellerRepo.findAll(any(PageRequest.class))).thenReturn(Page.empty());
//
//        // When
//        Page<Seller> result = service.findByPageAndSize(0, 10);
//
//        // Then
//        assertNotNull(result);
//        assertEquals(0, result.getTotalElements());
//    }
//
//    @Test
//    void searchSellerByName_existingSeller() {
//        UUID toset = UUID.randomUUID();
//        // Given
//        SellerInfo sellerInfo = new SellerInfo();
//        sellerInfo.setId(toset);
//        when(sellerInfoRepo.findSellerInfoByName(anyString())).thenReturn(sellerInfo);
//
//        // When
//        SellerInfo result = service.searchSellerByName("sellerName");
//
//        // Then
//        assertNotNull(result);
//        assertEquals(toset, result.getId());
//    }
//
//    @Test
//    void searchSellerByName_nonExistingSeller() {
//        // Given
//        when(sellerInfoRepo.findSellerInfoByName(anyString())).thenReturn(new SellerInfo());
//
//        // When/Then
//        assertThrows(RuntimeException.class, () -> service.searchSellerByName("sellerName"));
//    }
//
//    @Test
//    void getSellerInfoWithSortDirection() {
//        when(sellerInfoRepo.findAll(any(PageRequest.class))).thenReturn(Page.empty());
//
//        // When
//        Page<SellerInfo> result = service.getSellerInfoWithSortDirection(0, 10, SellerService.SortValues.NAME, Sort.Direction.ASC);
//
//        // Then
//        assertNotNull(result);
//        assertEquals(0, result.getTotalElements());
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
//        List<SellerPagebleResponse> result = service.getAllSellerData();
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
