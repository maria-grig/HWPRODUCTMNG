package ru.netology.manager;

import static javax.swing.UIManager.get;

public class ProductRep {
        private Product[] items = new Product[0];

        public void save(Product item) {
            int length = items.length + 1;
            Product[] tmp = new Product[length];
            System.arraycopy(items, 0, tmp, 0, items.length);
            int lastIndex = tmp.length - 1;
            tmp[lastIndex] = item;
            items = tmp;
        }

        public Product[] findAll() {
            return items;
        }
    public void removeById(int id) {

        if (findById(id) == null) {
            throw new NotFoundException(
                    "Element with id: " + id + " not found"
            );
        } else {
            int result = 0;
            for (Product item : items) {
                if (item.getId() != id) {
                    result++;
                }
            }
            Product[] tmp = new Product[result];
                for (Product item : items) {
                if (item.getId() != id) {
                    tmp[result] = item;
                    result++;
                }
            }
            items = tmp;
        }
    }

    public Product findById(int id) {
        for (Product item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;

    }

}
