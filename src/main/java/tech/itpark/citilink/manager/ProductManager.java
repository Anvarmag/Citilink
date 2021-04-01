package tech.itpark.citilink.manager;

import tech.itpark.citilink.domain.*;

import java.util.ArrayList;

public class ProductManager {
    // private ProductRepository repository = new ProductRepositoryInMemory();
    private ArrayList<Product> items = new ArrayList<>();

    public ArrayList<Product> getAll() {
        return items;
    }

    public Product getById(long id) {
        for (Product item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public Product updateById(long id, ProductUpdate dto) {
        for (Product item : items) {
            if (item.getId() == id) {
                item.setName(dto.getName());
                item.setPrice(dto.getPrice());
                return item;
            }
        }
        return null;
    }

    public void removeById(long id) {
        for (Product item : items) {
            if (item.getId() == id) {
                item.setRemoved(true);
            }
        }
    }


    // выделить + Ctrl + Shift + стрелки вверх/вниз
    public ArrayList<Product> search(String text) {
        ArrayList<Product> result = new ArrayList<>();
        String target = text.trim().toLowerCase();

        for (Product item : items) {
            if (contains(item.getName(), target)) {
                result.add(item);
                continue;
            }

            // inst + Tab
            if (item instanceof Book) {
                Book book = (Book) item;
                if (contains(book.getAuthor(), target)) {
                    result.add(item);
                    continue;
                }
            }
            if (item instanceof Cap) {
                Cap cap = (Cap) item;
                if (contains(cap.getSize(), target)) {
                    result.add(item);
                    continue;
                }
            }
            if (item instanceof Iphone) {
                Iphone iphone = (Iphone) item;
                if (contains(iphone.getColor(), target)) {
                    result.add(item);
                    continue;
                }
            }
            if (item instanceof Laptop) {
                Laptop laptop = (Laptop) item;
                if (contains(laptop.getCpu(), target)) {
                    result.add(item);
                    continue;
                }
            }
        }

        return result;
    }

    public ArrayList<Product> filter(String type) {
        ArrayList<Product> result = new ArrayList<>();

        // && - логическое И
        for (Product item : items) {
            if (type.equals("caps") && item instanceof Cap) {
                result.add(item);
                continue;
            }

            if (type.equals("books") && item instanceof Book) {
                result.add(item);
                continue;
            }

            if (type.equals("iphones") && item instanceof Iphone) {
                result.add(item);
                continue;
            }
            if (type.equals("laptops") && item instanceof Laptop) {
                result.add(item);
                continue;
            }
        }

        return result;
    }

    public void add(Product product) {
        items.add(product);
    }


    private boolean contains(String field, String target) {
        return field.toLowerCase().contains(target);
    }
}