#include <stdio.h>
#include <stdlib.h>

int main()
{
    int data[5] = {9, 3, 0, 5, 2};
    int i, j, temp, size = 5;
    int pass = 0;
    int ex = 1;

    while (i < size && ex != 0)
    {
        ex = 0;

        for (j = 0; j < (size - 1); j++)
        {
            if (data[j] > data[j + 1])
            {
                temp = data[j];
                data[j] = data[j + 1];
                data[j + 1] = temp;
                ex = ex + 1;
            }
        }
        pass = pass + 1;
        i = i + 1;
    }
    

    return 0;
}