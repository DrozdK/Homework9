package enums;

public enum SubCatalogItems {
    LAPTOPS_COMPUTERS_MONITORS("Ноутбуки, компьютеры, мониторы"),
    ACCESSORIES("Комплектующие"),
    DATA_STORAGE("Хранение данных"),
    NETWORK_EQUIPMENT("Сетевое оборудование");

    private final String item;

    SubCatalogItems(String item) {
        this.item = item;
    }

    public String getText() {
        return item;
    }
}
