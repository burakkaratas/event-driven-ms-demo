package net.burakkaratas.handler;

import lombok.RequiredArgsConstructor;
import net.burakkaratas.core.event.ProductCreatedEvent;
import net.burakkaratas.entity.ProductEntity;
import net.burakkaratas.repository.ProductRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductEventsHandler
{
    private final ProductRepository productRepository;

    @EventHandler
    public void on(ProductCreatedEvent event)
    {
        ProductEntity productEntity = new ProductEntity();
        BeanUtils.copyProperties(event,productEntity);
        productRepository.save(productEntity);
    }
}
