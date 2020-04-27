package com.community.entity.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EnvironmentDataExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EnvironmentDataExample() {
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

        public Criteria andUserIdIsNull() {
            addCriterion("`user_id` is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("`user_id` is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("`user_id` =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("`user_id` <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("`user_id` >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("`user_id` >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("`user_id` <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("`user_id` <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("`user_id` like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("`user_id` not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("`user_id` in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("`user_id` not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("`user_id` between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("`user_id` not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdIsNull() {
            addCriterion("`device_id` is null");
            return (Criteria) this;
        }

        public Criteria andDeviceIdIsNotNull() {
            addCriterion("`device_id` is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceIdEqualTo(String value) {
            addCriterion("`device_id` =", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotEqualTo(String value) {
            addCriterion("`device_id` <>", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdGreaterThan(String value) {
            addCriterion("`device_id` >", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdGreaterThanOrEqualTo(String value) {
            addCriterion("`device_id` >=", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdLessThan(String value) {
            addCriterion("`device_id` <", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdLessThanOrEqualTo(String value) {
            addCriterion("`device_id` <=", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdLike(String value) {
            addCriterion("`device_id` like", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotLike(String value) {
            addCriterion("`device_id` not like", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdIn(List<String> values) {
            addCriterion("`device_id` in", values, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotIn(List<String> values) {
            addCriterion("`device_id` not in", values, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdBetween(String value1, String value2) {
            addCriterion("`device_id` between", value1, value2, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotBetween(String value1, String value2) {
            addCriterion("`device_id` not between", value1, value2, "deviceId");
            return (Criteria) this;
        }

        public Criteria andIndoorTemperatureIsNull() {
            addCriterion("`indoor_temperature` is null");
            return (Criteria) this;
        }

        public Criteria andIndoorTemperatureIsNotNull() {
            addCriterion("`indoor_temperature` is not null");
            return (Criteria) this;
        }

        public Criteria andIndoorTemperatureEqualTo(Double value) {
            addCriterion("`indoor_temperature` =", value, "indoorTemperature");
            return (Criteria) this;
        }

        public Criteria andIndoorTemperatureNotEqualTo(Double value) {
            addCriterion("`indoor_temperature` <>", value, "indoorTemperature");
            return (Criteria) this;
        }

        public Criteria andIndoorTemperatureGreaterThan(Double value) {
            addCriterion("`indoor_temperature` >", value, "indoorTemperature");
            return (Criteria) this;
        }

        public Criteria andIndoorTemperatureGreaterThanOrEqualTo(Double value) {
            addCriterion("`indoor_temperature` >=", value, "indoorTemperature");
            return (Criteria) this;
        }

        public Criteria andIndoorTemperatureLessThan(Double value) {
            addCriterion("`indoor_temperature` <", value, "indoorTemperature");
            return (Criteria) this;
        }

        public Criteria andIndoorTemperatureLessThanOrEqualTo(Double value) {
            addCriterion("`indoor_temperature` <=", value, "indoorTemperature");
            return (Criteria) this;
        }

        public Criteria andIndoorTemperatureIn(List<Double> values) {
            addCriterion("`indoor_temperature` in", values, "indoorTemperature");
            return (Criteria) this;
        }

        public Criteria andIndoorTemperatureNotIn(List<Double> values) {
            addCriterion("`indoor_temperature` not in", values, "indoorTemperature");
            return (Criteria) this;
        }

        public Criteria andIndoorTemperatureBetween(Double value1, Double value2) {
            addCriterion("`indoor_temperature` between", value1, value2, "indoorTemperature");
            return (Criteria) this;
        }

        public Criteria andIndoorTemperatureNotBetween(Double value1, Double value2) {
            addCriterion("`indoor_temperature` not between", value1, value2, "indoorTemperature");
            return (Criteria) this;
        }

        public Criteria andHumidityIsNull() {
            addCriterion("`humidity` is null");
            return (Criteria) this;
        }

        public Criteria andHumidityIsNotNull() {
            addCriterion("`humidity` is not null");
            return (Criteria) this;
        }

        public Criteria andHumidityEqualTo(Double value) {
            addCriterion("`humidity` =", value, "humidity");
            return (Criteria) this;
        }

        public Criteria andHumidityNotEqualTo(Double value) {
            addCriterion("`humidity` <>", value, "humidity");
            return (Criteria) this;
        }

        public Criteria andHumidityGreaterThan(Double value) {
            addCriterion("`humidity` >", value, "humidity");
            return (Criteria) this;
        }

        public Criteria andHumidityGreaterThanOrEqualTo(Double value) {
            addCriterion("`humidity` >=", value, "humidity");
            return (Criteria) this;
        }

        public Criteria andHumidityLessThan(Double value) {
            addCriterion("`humidity` <", value, "humidity");
            return (Criteria) this;
        }

        public Criteria andHumidityLessThanOrEqualTo(Double value) {
            addCriterion("`humidity` <=", value, "humidity");
            return (Criteria) this;
        }

        public Criteria andHumidityIn(List<Double> values) {
            addCriterion("`humidity` in", values, "humidity");
            return (Criteria) this;
        }

        public Criteria andHumidityNotIn(List<Double> values) {
            addCriterion("`humidity` not in", values, "humidity");
            return (Criteria) this;
        }

        public Criteria andHumidityBetween(Double value1, Double value2) {
            addCriterion("`humidity` between", value1, value2, "humidity");
            return (Criteria) this;
        }

        public Criteria andHumidityNotBetween(Double value1, Double value2) {
            addCriterion("`humidity` not between", value1, value2, "humidity");
            return (Criteria) this;
        }

        public Criteria andSmokeConcentrationIsNull() {
            addCriterion("`smoke_concentration` is null");
            return (Criteria) this;
        }

        public Criteria andSmokeConcentrationIsNotNull() {
            addCriterion("`smoke_concentration` is not null");
            return (Criteria) this;
        }

        public Criteria andSmokeConcentrationEqualTo(Double value) {
            addCriterion("`smoke_concentration` =", value, "smokeConcentration");
            return (Criteria) this;
        }

        public Criteria andSmokeConcentrationNotEqualTo(Double value) {
            addCriterion("`smoke_concentration` <>", value, "smokeConcentration");
            return (Criteria) this;
        }

        public Criteria andSmokeConcentrationGreaterThan(Double value) {
            addCriterion("`smoke_concentration` >", value, "smokeConcentration");
            return (Criteria) this;
        }

        public Criteria andSmokeConcentrationGreaterThanOrEqualTo(Double value) {
            addCriterion("`smoke_concentration` >=", value, "smokeConcentration");
            return (Criteria) this;
        }

        public Criteria andSmokeConcentrationLessThan(Double value) {
            addCriterion("`smoke_concentration` <", value, "smokeConcentration");
            return (Criteria) this;
        }

        public Criteria andSmokeConcentrationLessThanOrEqualTo(Double value) {
            addCriterion("`smoke_concentration` <=", value, "smokeConcentration");
            return (Criteria) this;
        }

        public Criteria andSmokeConcentrationIn(List<Double> values) {
            addCriterion("`smoke_concentration` in", values, "smokeConcentration");
            return (Criteria) this;
        }

        public Criteria andSmokeConcentrationNotIn(List<Double> values) {
            addCriterion("`smoke_concentration` not in", values, "smokeConcentration");
            return (Criteria) this;
        }

        public Criteria andSmokeConcentrationBetween(Double value1, Double value2) {
            addCriterion("`smoke_concentration` between", value1, value2, "smokeConcentration");
            return (Criteria) this;
        }

        public Criteria andSmokeConcentrationNotBetween(Double value1, Double value2) {
            addCriterion("`smoke_concentration` not between", value1, value2, "smokeConcentration");
            return (Criteria) this;
        }

        public Criteria andLightIntensityIsNull() {
            addCriterion("`light_intensity` is null");
            return (Criteria) this;
        }

        public Criteria andLightIntensityIsNotNull() {
            addCriterion("`light_intensity` is not null");
            return (Criteria) this;
        }

        public Criteria andLightIntensityEqualTo(Double value) {
            addCriterion("`light_intensity` =", value, "lightIntensity");
            return (Criteria) this;
        }

        public Criteria andLightIntensityNotEqualTo(Double value) {
            addCriterion("`light_intensity` <>", value, "lightIntensity");
            return (Criteria) this;
        }

        public Criteria andLightIntensityGreaterThan(Double value) {
            addCriterion("`light_intensity` >", value, "lightIntensity");
            return (Criteria) this;
        }

        public Criteria andLightIntensityGreaterThanOrEqualTo(Double value) {
            addCriterion("`light_intensity` >=", value, "lightIntensity");
            return (Criteria) this;
        }

        public Criteria andLightIntensityLessThan(Double value) {
            addCriterion("`light_intensity` <", value, "lightIntensity");
            return (Criteria) this;
        }

        public Criteria andLightIntensityLessThanOrEqualTo(Double value) {
            addCriterion("`light_intensity` <=", value, "lightIntensity");
            return (Criteria) this;
        }

        public Criteria andLightIntensityIn(List<Double> values) {
            addCriterion("`light_intensity` in", values, "lightIntensity");
            return (Criteria) this;
        }

        public Criteria andLightIntensityNotIn(List<Double> values) {
            addCriterion("`light_intensity` not in", values, "lightIntensity");
            return (Criteria) this;
        }

        public Criteria andLightIntensityBetween(Double value1, Double value2) {
            addCriterion("`light_intensity` between", value1, value2, "lightIntensity");
            return (Criteria) this;
        }

        public Criteria andLightIntensityNotBetween(Double value1, Double value2) {
            addCriterion("`light_intensity` not between", value1, value2, "lightIntensity");
            return (Criteria) this;
        }

        public Criteria andUploadDateIsNull() {
            addCriterion("`upload_date` is null");
            return (Criteria) this;
        }

        public Criteria andUploadDateIsNotNull() {
            addCriterion("`upload_date` is not null");
            return (Criteria) this;
        }

        public Criteria andUploadDateEqualTo(Date value) {
            addCriterion("`upload_date` =", value, "uploadDate");
            return (Criteria) this;
        }

        public Criteria andUploadDateNotEqualTo(Date value) {
            addCriterion("`upload_date` <>", value, "uploadDate");
            return (Criteria) this;
        }

        public Criteria andUploadDateGreaterThan(Date value) {
            addCriterion("`upload_date` >", value, "uploadDate");
            return (Criteria) this;
        }

        public Criteria andUploadDateGreaterThanOrEqualTo(Date value) {
            addCriterion("`upload_date` >=", value, "uploadDate");
            return (Criteria) this;
        }

        public Criteria andUploadDateLessThan(Date value) {
            addCriterion("`upload_date` <", value, "uploadDate");
            return (Criteria) this;
        }

        public Criteria andUploadDateLessThanOrEqualTo(Date value) {
            addCriterion("`upload_date` <=", value, "uploadDate");
            return (Criteria) this;
        }

        public Criteria andUploadDateIn(List<Date> values) {
            addCriterion("`upload_date` in", values, "uploadDate");
            return (Criteria) this;
        }

        public Criteria andUploadDateNotIn(List<Date> values) {
            addCriterion("`upload_date` not in", values, "uploadDate");
            return (Criteria) this;
        }

        public Criteria andUploadDateBetween(Date value1, Date value2) {
            addCriterion("`upload_date` between", value1, value2, "uploadDate");
            return (Criteria) this;
        }

        public Criteria andUploadDateNotBetween(Date value1, Date value2) {
            addCriterion("`upload_date` not between", value1, value2, "uploadDate");
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