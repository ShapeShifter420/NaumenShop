package org.TeamDream.NaumenShop.models;

public class Filter {
    private int  categoryId;

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
    public String getSQLString()
    {
        return String.format("AND category_id = \"%s\"",this.categoryId);
    }
}
