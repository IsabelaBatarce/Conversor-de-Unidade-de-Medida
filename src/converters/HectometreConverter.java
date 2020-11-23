package converters;

public class HectometreConverter implements IConverterMaster {

    public double fromBasicUnit(double value) {
        return value / 100;
    }

    public double toBasicUnit(double value) {
        return value * 100;
    }

    public Double convert(IConverterMaster sourceMeasurement, double value) {
        return this.fromBasicUnit(sourceMeasurement.toBasicUnit(value));
    }

    public String toString() {
        String textComboBox = String.format("hectometre (hm) [%s]: %s", MeasureType.DISTANCE.getTypeString(), getClass().getCanonicalName());

        return textComboBox;
    }
}