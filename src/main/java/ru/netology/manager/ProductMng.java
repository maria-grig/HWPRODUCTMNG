package ru.netology.manager;

public class ProductMng {
    private ProductRep repo;

    public ProductMng(ProductRep repo) {
        this.repo = repo;
    }

    public void add(Product product) {
            repo.save(product);
        }

        public Product[] searchBy(String text) {
            Product[] result = new Product[0];
            for (Product product : repo.findAll()) {
                if (matches(product, text)) {
                    int length = result.length + 1;
                    Product[] tmp = new Product[length];
                    System.arraycopy(result, 0, tmp, 0, result.length);
                    int lastIndex = tmp.length - 1;
                    tmp[lastIndex] = product;
                    result = tmp;
                }
            }
            return result;
        }

        public boolean matches(Product product, String search) {
            if (product.getName().contains(search)) {
                return true;
            } else {
                return false;
            }
        }

    }