Console.WriteLine("¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨");
Console.WriteLine("         Calculadora activada");
Console.WriteLine("_______________________________________");
int x;
int y;
do
{
    Console.Write("Por favor, introduce un número positivo: ");
    x = int.Parse(Console.ReadLine());
}
while (x < 1);
do
{
    Console.Write("Introduce otro número positivo: ");
    y = int.Parse(Console.ReadLine());
}
while (y < 1);
int c;
do
{
    Console.WriteLine();
    Console.WriteLine("     Elige operación:    Pulsa:");
    Console.WriteLine("     ¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨    ¨¨¨¨¨¨");
    Console.WriteLine("         Suma              1");
    Console.WriteLine("         Resta             2");
    Console.WriteLine("         Multiplicación    3");
    Console.WriteLine("         División          4");
    Console.WriteLine();
    Console.WriteLine("         Salir             5");
    Console.WriteLine();
    c = int.Parse(Console.ReadLine());
    Console.WriteLine("¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨");
    switch (c)
    {
        case < 1:
        case > 5:
            Console.WriteLine("         ¡" + c + " no es válido!");
            Console.WriteLine("");
            Console.WriteLine("     Elige una opción válida del menú:");
            break;
        case 1:
            Console.WriteLine("     Resultado de sumar  " + x + "  más  " + y + "  =  " + (x + y));
            break;
        case 2:
            Console.WriteLine("     Resultado de restar  " + x + "  menos  " + y + "  =  " + (x - y));
            break;
        case 3:
            Console.WriteLine("     Resultado de  " + x + "  multiplicado por  " + y + "  =  " + (x * y));
            break;
        case 4:
            Console.WriteLine("     Resultado de  " + x + "  dividido por  " + y + "  =  " + (x / y));
            break;
        case 5:
            Console.WriteLine("             ¡Hasta luego!");
            break;
    }
    Console.WriteLine("_______________________________________");
}
while (c != 5);
