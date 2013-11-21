package TP2;

/** Mode
 * Enumerado con los distintos tipos modos de corrida que hay:
 * Standard, FailedAndNew para correr los test que fallaron y los nuevos, y Recover para correr una corrida anterior
 **/

public enum RunMode {
	Standard,
	FailedAndNew,
	Recover
}