package com.pinyougou.pojo;

import java.util.ArrayList;
import java.util.List;

public class TbGoodsDescExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbGoodsDescExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andGoods_idIsNull() {
            addCriterion("goods_id is null");
            return (Criteria) this;
        }

        public Criteria andGoods_idIsNotNull() {
            addCriterion("goods_id is not null");
            return (Criteria) this;
        }

        public Criteria andGoods_idEqualTo(Long value) {
            addCriterion("goods_id =", value, "goods_id");
            return (Criteria) this;
        }

        public Criteria andGoods_idNotEqualTo(Long value) {
            addCriterion("goods_id <>", value, "goods_id");
            return (Criteria) this;
        }

        public Criteria andGoods_idGreaterThan(Long value) {
            addCriterion("goods_id >", value, "goods_id");
            return (Criteria) this;
        }

        public Criteria andGoods_idGreaterThanOrEqualTo(Long value) {
            addCriterion("goods_id >=", value, "goods_id");
            return (Criteria) this;
        }

        public Criteria andGoods_idLessThan(Long value) {
            addCriterion("goods_id <", value, "goods_id");
            return (Criteria) this;
        }

        public Criteria andGoods_idLessThanOrEqualTo(Long value) {
            addCriterion("goods_id <=", value, "goods_id");
            return (Criteria) this;
        }

        public Criteria andGoods_idIn(List<Long> values) {
            addCriterion("goods_id in", values, "goods_id");
            return (Criteria) this;
        }

        public Criteria andGoods_idNotIn(List<Long> values) {
            addCriterion("goods_id not in", values, "goods_id");
            return (Criteria) this;
        }

        public Criteria andGoods_idBetween(Long value1, Long value2) {
            addCriterion("goods_id between", value1, value2, "goods_id");
            return (Criteria) this;
        }

        public Criteria andGoods_idNotBetween(Long value1, Long value2) {
            addCriterion("goods_id not between", value1, value2, "goods_id");
            return (Criteria) this;
        }

        public Criteria andIntroductionIsNull() {
            addCriterion("introduction is null");
            return (Criteria) this;
        }

        public Criteria andIntroductionIsNotNull() {
            addCriterion("introduction is not null");
            return (Criteria) this;
        }

        public Criteria andIntroductionEqualTo(String value) {
            addCriterion("introduction =", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotEqualTo(String value) {
            addCriterion("introduction <>", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionGreaterThan(String value) {
            addCriterion("introduction >", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionGreaterThanOrEqualTo(String value) {
            addCriterion("introduction >=", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionLessThan(String value) {
            addCriterion("introduction <", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionLessThanOrEqualTo(String value) {
            addCriterion("introduction <=", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionLike(String value) {
            addCriterion("introduction like", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotLike(String value) {
            addCriterion("introduction not like", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionIn(List<String> values) {
            addCriterion("introduction in", values, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotIn(List<String> values) {
            addCriterion("introduction not in", values, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionBetween(String value1, String value2) {
            addCriterion("introduction between", value1, value2, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotBetween(String value1, String value2) {
            addCriterion("introduction not between", value1, value2, "introduction");
            return (Criteria) this;
        }

        public Criteria andSpecification_itemsIsNull() {
            addCriterion("specification_items is null");
            return (Criteria) this;
        }

        public Criteria andSpecification_itemsIsNotNull() {
            addCriterion("specification_items is not null");
            return (Criteria) this;
        }

        public Criteria andSpecification_itemsEqualTo(String value) {
            addCriterion("specification_items =", value, "specification_items");
            return (Criteria) this;
        }

        public Criteria andSpecification_itemsNotEqualTo(String value) {
            addCriterion("specification_items <>", value, "specification_items");
            return (Criteria) this;
        }

        public Criteria andSpecification_itemsGreaterThan(String value) {
            addCriterion("specification_items >", value, "specification_items");
            return (Criteria) this;
        }

        public Criteria andSpecification_itemsGreaterThanOrEqualTo(String value) {
            addCriterion("specification_items >=", value, "specification_items");
            return (Criteria) this;
        }

        public Criteria andSpecification_itemsLessThan(String value) {
            addCriterion("specification_items <", value, "specification_items");
            return (Criteria) this;
        }

        public Criteria andSpecification_itemsLessThanOrEqualTo(String value) {
            addCriterion("specification_items <=", value, "specification_items");
            return (Criteria) this;
        }

        public Criteria andSpecification_itemsLike(String value) {
            addCriterion("specification_items like", value, "specification_items");
            return (Criteria) this;
        }

        public Criteria andSpecification_itemsNotLike(String value) {
            addCriterion("specification_items not like", value, "specification_items");
            return (Criteria) this;
        }

        public Criteria andSpecification_itemsIn(List<String> values) {
            addCriterion("specification_items in", values, "specification_items");
            return (Criteria) this;
        }

        public Criteria andSpecification_itemsNotIn(List<String> values) {
            addCriterion("specification_items not in", values, "specification_items");
            return (Criteria) this;
        }

        public Criteria andSpecification_itemsBetween(String value1, String value2) {
            addCriterion("specification_items between", value1, value2, "specification_items");
            return (Criteria) this;
        }

        public Criteria andSpecification_itemsNotBetween(String value1, String value2) {
            addCriterion("specification_items not between", value1, value2, "specification_items");
            return (Criteria) this;
        }

        public Criteria andCustom_attribute_itemsIsNull() {
            addCriterion("custom_attribute_items is null");
            return (Criteria) this;
        }

        public Criteria andCustom_attribute_itemsIsNotNull() {
            addCriterion("custom_attribute_items is not null");
            return (Criteria) this;
        }

        public Criteria andCustom_attribute_itemsEqualTo(String value) {
            addCriterion("custom_attribute_items =", value, "custom_attribute_items");
            return (Criteria) this;
        }

        public Criteria andCustom_attribute_itemsNotEqualTo(String value) {
            addCriterion("custom_attribute_items <>", value, "custom_attribute_items");
            return (Criteria) this;
        }

        public Criteria andCustom_attribute_itemsGreaterThan(String value) {
            addCriterion("custom_attribute_items >", value, "custom_attribute_items");
            return (Criteria) this;
        }

        public Criteria andCustom_attribute_itemsGreaterThanOrEqualTo(String value) {
            addCriterion("custom_attribute_items >=", value, "custom_attribute_items");
            return (Criteria) this;
        }

        public Criteria andCustom_attribute_itemsLessThan(String value) {
            addCriterion("custom_attribute_items <", value, "custom_attribute_items");
            return (Criteria) this;
        }

        public Criteria andCustom_attribute_itemsLessThanOrEqualTo(String value) {
            addCriterion("custom_attribute_items <=", value, "custom_attribute_items");
            return (Criteria) this;
        }

        public Criteria andCustom_attribute_itemsLike(String value) {
            addCriterion("custom_attribute_items like", value, "custom_attribute_items");
            return (Criteria) this;
        }

        public Criteria andCustom_attribute_itemsNotLike(String value) {
            addCriterion("custom_attribute_items not like", value, "custom_attribute_items");
            return (Criteria) this;
        }

        public Criteria andCustom_attribute_itemsIn(List<String> values) {
            addCriterion("custom_attribute_items in", values, "custom_attribute_items");
            return (Criteria) this;
        }

        public Criteria andCustom_attribute_itemsNotIn(List<String> values) {
            addCriterion("custom_attribute_items not in", values, "custom_attribute_items");
            return (Criteria) this;
        }

        public Criteria andCustom_attribute_itemsBetween(String value1, String value2) {
            addCriterion("custom_attribute_items between", value1, value2, "custom_attribute_items");
            return (Criteria) this;
        }

        public Criteria andCustom_attribute_itemsNotBetween(String value1, String value2) {
            addCriterion("custom_attribute_items not between", value1, value2, "custom_attribute_items");
            return (Criteria) this;
        }

        public Criteria andItem_imagesIsNull() {
            addCriterion("item_images is null");
            return (Criteria) this;
        }

        public Criteria andItem_imagesIsNotNull() {
            addCriterion("item_images is not null");
            return (Criteria) this;
        }

        public Criteria andItem_imagesEqualTo(String value) {
            addCriterion("item_images =", value, "item_images");
            return (Criteria) this;
        }

        public Criteria andItem_imagesNotEqualTo(String value) {
            addCriterion("item_images <>", value, "item_images");
            return (Criteria) this;
        }

        public Criteria andItem_imagesGreaterThan(String value) {
            addCriterion("item_images >", value, "item_images");
            return (Criteria) this;
        }

        public Criteria andItem_imagesGreaterThanOrEqualTo(String value) {
            addCriterion("item_images >=", value, "item_images");
            return (Criteria) this;
        }

        public Criteria andItem_imagesLessThan(String value) {
            addCriterion("item_images <", value, "item_images");
            return (Criteria) this;
        }

        public Criteria andItem_imagesLessThanOrEqualTo(String value) {
            addCriterion("item_images <=", value, "item_images");
            return (Criteria) this;
        }

        public Criteria andItem_imagesLike(String value) {
            addCriterion("item_images like", value, "item_images");
            return (Criteria) this;
        }

        public Criteria andItem_imagesNotLike(String value) {
            addCriterion("item_images not like", value, "item_images");
            return (Criteria) this;
        }

        public Criteria andItem_imagesIn(List<String> values) {
            addCriterion("item_images in", values, "item_images");
            return (Criteria) this;
        }

        public Criteria andItem_imagesNotIn(List<String> values) {
            addCriterion("item_images not in", values, "item_images");
            return (Criteria) this;
        }

        public Criteria andItem_imagesBetween(String value1, String value2) {
            addCriterion("item_images between", value1, value2, "item_images");
            return (Criteria) this;
        }

        public Criteria andItem_imagesNotBetween(String value1, String value2) {
            addCriterion("item_images not between", value1, value2, "item_images");
            return (Criteria) this;
        }

        public Criteria andPackage_listIsNull() {
            addCriterion("package_list is null");
            return (Criteria) this;
        }

        public Criteria andPackage_listIsNotNull() {
            addCriterion("package_list is not null");
            return (Criteria) this;
        }

        public Criteria andPackage_listEqualTo(String value) {
            addCriterion("package_list =", value, "package_list");
            return (Criteria) this;
        }

        public Criteria andPackage_listNotEqualTo(String value) {
            addCriterion("package_list <>", value, "package_list");
            return (Criteria) this;
        }

        public Criteria andPackage_listGreaterThan(String value) {
            addCriterion("package_list >", value, "package_list");
            return (Criteria) this;
        }

        public Criteria andPackage_listGreaterThanOrEqualTo(String value) {
            addCriterion("package_list >=", value, "package_list");
            return (Criteria) this;
        }

        public Criteria andPackage_listLessThan(String value) {
            addCriterion("package_list <", value, "package_list");
            return (Criteria) this;
        }

        public Criteria andPackage_listLessThanOrEqualTo(String value) {
            addCriterion("package_list <=", value, "package_list");
            return (Criteria) this;
        }

        public Criteria andPackage_listLike(String value) {
            addCriterion("package_list like", value, "package_list");
            return (Criteria) this;
        }

        public Criteria andPackage_listNotLike(String value) {
            addCriterion("package_list not like", value, "package_list");
            return (Criteria) this;
        }

        public Criteria andPackage_listIn(List<String> values) {
            addCriterion("package_list in", values, "package_list");
            return (Criteria) this;
        }

        public Criteria andPackage_listNotIn(List<String> values) {
            addCriterion("package_list not in", values, "package_list");
            return (Criteria) this;
        }

        public Criteria andPackage_listBetween(String value1, String value2) {
            addCriterion("package_list between", value1, value2, "package_list");
            return (Criteria) this;
        }

        public Criteria andPackage_listNotBetween(String value1, String value2) {
            addCriterion("package_list not between", value1, value2, "package_list");
            return (Criteria) this;
        }

        public Criteria andSale_serviceIsNull() {
            addCriterion("sale_service is null");
            return (Criteria) this;
        }

        public Criteria andSale_serviceIsNotNull() {
            addCriterion("sale_service is not null");
            return (Criteria) this;
        }

        public Criteria andSale_serviceEqualTo(String value) {
            addCriterion("sale_service =", value, "sale_service");
            return (Criteria) this;
        }

        public Criteria andSale_serviceNotEqualTo(String value) {
            addCriterion("sale_service <>", value, "sale_service");
            return (Criteria) this;
        }

        public Criteria andSale_serviceGreaterThan(String value) {
            addCriterion("sale_service >", value, "sale_service");
            return (Criteria) this;
        }

        public Criteria andSale_serviceGreaterThanOrEqualTo(String value) {
            addCriterion("sale_service >=", value, "sale_service");
            return (Criteria) this;
        }

        public Criteria andSale_serviceLessThan(String value) {
            addCriterion("sale_service <", value, "sale_service");
            return (Criteria) this;
        }

        public Criteria andSale_serviceLessThanOrEqualTo(String value) {
            addCriterion("sale_service <=", value, "sale_service");
            return (Criteria) this;
        }

        public Criteria andSale_serviceLike(String value) {
            addCriterion("sale_service like", value, "sale_service");
            return (Criteria) this;
        }

        public Criteria andSale_serviceNotLike(String value) {
            addCriterion("sale_service not like", value, "sale_service");
            return (Criteria) this;
        }

        public Criteria andSale_serviceIn(List<String> values) {
            addCriterion("sale_service in", values, "sale_service");
            return (Criteria) this;
        }

        public Criteria andSale_serviceNotIn(List<String> values) {
            addCriterion("sale_service not in", values, "sale_service");
            return (Criteria) this;
        }

        public Criteria andSale_serviceBetween(String value1, String value2) {
            addCriterion("sale_service between", value1, value2, "sale_service");
            return (Criteria) this;
        }

        public Criteria andSale_serviceNotBetween(String value1, String value2) {
            addCriterion("sale_service not between", value1, value2, "sale_service");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}