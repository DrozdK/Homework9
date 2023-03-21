package enums;

public enum CatalogItems {
    ELECTRONIC("Электроника"),
    COMPUTERS("Компьютеры и сети"),
    HOUSEHOLD_APPLIANCE("Бытовая техника"),
    FOR_EVERY_DAY("На каждый день"),
    BUILDIND_AND_REPAIR("Стройка и ремонт"),
    HOME_AND_GARDEN("Дом и сад"),
    AUTO_AND_MOTO("Авто и мото"),
    BEAUTY_AND_SPORT("Красота и спорт"),
    CHILDREN_AND_MOTHERS("Детям и мамам");

    private final String item;

    CatalogItems(String item) {
        this.item = item;
    }

    public String getText() {
        return item;
    }
}
