package Java7ConcurrencyCookbook.chp5.p2;

import java.util.ArrayList;
import java.util.List;

/**
 * 生成一个随机产品列表
 */
public class ProductGeneratorList {
    public List<Product> generate (int size){
        List<Product> ret = new ArrayList<Product>();

        for (int i = 0; i < size; i++) {
            Product product = new Product();
            product.setName("Product " + i);
            product.setPrice(10);
            ret.add(product);
        }
        return ret;
    }
}
