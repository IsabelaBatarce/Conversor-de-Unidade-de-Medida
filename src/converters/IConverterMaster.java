package converters;

/**
 * Classe pai com os metodos para a conversao das unidades de medida
 */
public interface IConverterMaster {

    double fromBasicUnit(double value);

    double toBasicUnit(double value);

    Double convert(IConverterMaster sourceMeasurement, double value);
}
