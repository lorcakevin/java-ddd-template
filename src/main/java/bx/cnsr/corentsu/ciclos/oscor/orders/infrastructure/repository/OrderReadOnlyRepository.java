package bx.cnsr.corentsu.ciclos.oscor.orders.infrastructure.repository;

import bx.cnsr.corentsu.ciclos.oscor.orders.domain.Order;
import bx.cnsr.corentsu.ciclos.oscor.orders.domain.Package;
import bx.cnsr.corentsu.ciclos.oscor.orders.domain.repository.IOrderReadOnlyRepository;
import bx.cnsr.corentsu.ciclos.oscor.orders.infrastructure.repository.entity.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class OrderReadOnlyRepository implements IOrderReadOnlyRepository {
    @Autowired
    OrderReadOnlyMongoRepository orderRORepo;

    public void insertOrder(Order order) {

        List<PackageDTO> packagesDTO = new ArrayList<>();
        for(Package packageEntity : order.getPackages() ){
            packagesDTO.add(new PackageDTO(packageEntity));
        }

        List<String> references = new ArrayList<>(order.getReferences());

        OrderReadOnlyDTO orderRODTO = OrderReadOnlyDTO.builder()
                .referenceOrder(order.getReferenceOrder())
                .orderId(order.getOrderId())
                .codeState(order.getCodeState())
                .declaredValue(order.getDeclaredValue())
                .emissionDate(order.getEmissionDate())
                .isDangerousShipping(order.isDangerousShipping())
                .productDesc(order.getProductDesc())
                .quantityPackages(order.getQuantityPackages())
                .productFamily(order.getProductFamily())
                .productType(order.getProductType())
                .promiseDate(order.getPromiseDate())
                .observation(order.getObservation())
                .state(order.getState())
                .serviceDesc(order.getServiceDesc())
                .serviceType(order.getServiceType())
                .volume(order.getVolume())
                .weight(order.getWeight())
                .taxDocument(new TaxDocumentDTO(order.getTaxDocument()))
                .shipping(new ShippingDTO(order.getShipping()))
                .packages(packagesDTO)
                .seller(new SellerDTO(order.getSeller()))
                .references(references)
                .dd(new DdDTO(order.getDd()))
                .insurance(new InsuranceDTO(order.getInsurance()))
                .cod(new CodDTO(order.getCod()))
                .buyer(new BuyerDTO(order.getBuyer()))

                .build();
        orderRORepo.insert(orderRODTO);
    }

}
