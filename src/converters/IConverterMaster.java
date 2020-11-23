package converters;

public interface IConverterMaster {

    double fromBasicUnit(double value);

    double toBasicUnit(double value);

    Double convert(IConverterMaster sourceMeasurement, double value);
}
