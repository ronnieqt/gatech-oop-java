// Constant Interface: 
// an interface with the sole purpose of containing constant definitions
// i.e., having no declared or defined methods

// This practice of having constant interfaces is not common and is widely considered to be an anti-pattern.
// Constant interfaces, they represent a significant step away from 
//   the core intention of interfaces as constructs for declaring behaviors.

public interface IChemistryConstants
{
    public static final double AVOGADROS_NUMBER = 6.02214199e23;
    public static final double FARADAY_CONSTANT = 96485.33;
    public static final double COULOMB_CONSTANT = 8.987551e9;
    public static final double PLANCK_CONSTANT = 6.62607004e34;
}
