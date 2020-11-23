package converters;

public class SoccerFieldConverter implements IConverterMaster {

    public double fromBasicUnit(double value) {
        return value / 7140;
    }

    public double toBasicUnit(double value) {
        return value * 7140;
    }

    public Double convert(IConverterMaster sourceMeasurement, double value) {
        return this.fromBasicUnit(sourceMeasurement.toBasicUnit(value));
    }

    public String toString() {
        String textComboBox = String.format("soccer field (FIFA) (--)  [%s]: %s", MeasureType.AREA.getTypeString(), getClass().getCanonicalName());

        return textComboBox;
    }
}