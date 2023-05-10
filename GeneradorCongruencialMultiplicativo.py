# La función verifica que los parámetros de entrada sean válidos para generar números aleatorios. Primero, comprueba que todos los parámetros son enteros. Siendo el módulo (m) mayor que cero, el multiplicador (a) se encuentre en el rango (0, m) y que el multiplicador y el módulo sean primos entre si. Si alguno de estos criterios no se cumple, se genera una el error.
# La función utiliza los parámetros:
# semilla: el valor inicial de la serie pseudoaleatoria
# a: La constante multiplicativa
# m: el módulo
# n: la cantidad de números pseudoaleatorios a generar
# Xo: la semilla

# Uso de librería p/ calculo del módulo 
import math

def generadorCongruencialMultiplicativo(semilla, a, m, n):
    print( "Validacion de parametros:")
    if not (isinstance(semilla, int) and isinstance(a, int) and isinstance(m, int) and isinstance(n, int)):
        raise TypeError("Todos los parametros deben ser enteros")
        print
    else: print("Todos los parametros son enteros")

    if m <= 0:
        raise ValueError("El modulo 'm' debe ser mayor que cero")
    else: print("El modulo 'm' es valido, por ser mayor a cero")

    if a <= 0 or a >= m:
        raise ValueError("La ctte multiplicativa 'a' debe estar en el rango (0, m)")
    else: print("La ctte multiplicativa 'a' es valida al estar en el rango (0, m)")

    if math.gcd(a, m) != 1:
        raise ValueError("La ctte multiplicativa 'a' y el modulo 'm' deben ser primos entre si")
    else: print("La ctte multiplicativa 'a' y el modulo 'm' son validos al ser primos entre si")

    if n <= 0:
        raise ValueError("n debe ser mayor a cero")
    print("--------------------------------------------------------------------------------------")

    # Generamos iteraciones de números aleatorios
    numerosAleatorios = []
    x = semilla
    print("{:>10} {:>10} {:>10} {:>12} {:>12}".format("Iteracion(n)", "Xn" ,"a*Xn" , "Xn+1", "Random Ui"))
    for i in range(n+1):
        numerosAleatorios.append(x / m)
        print("{:>10} {:>10} {:>12} {:>12} {:>12}".format(i+1, x , a * x ,  (a * x) % m , numerosAleatorios[-1] ))
        x = (a * x) % m
    #return numerosAleatorios

generador = generadorCongruencialMultiplicativo(semilla=7, a=5, m=64, n=33)
print(generador)

