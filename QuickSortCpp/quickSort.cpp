#include <bits/stdc++.h>

int partition(int array[], int low, int high)
{
    int pivot = array[high];

    int index = low - 1;

    for (int i = low; i < high; i++)
    {
        if (array[i] < pivot)
        {
            index++;
            std::swap(array[index], array[i]);
        }
    }
    std::swap(array[index + 1], array[high]);

    return index + 1;
}

void quickSort(int array[], int low, int high)
{
    if (low < high)
    {
        int returnIndex = partition(array, low, high);

        quickSort(array, low, returnIndex - 1);
        quickSort(array, returnIndex + 1, high);
    }
}

int main()
{
    int array[] = {0, 6, 5, 1, 2, 9};

    int arraySize = sizeof(array) / sizeof(array[0]);

    quickSort(array, 0, arraySize - 1);

    for (int i = 0; i < arraySize; i++)
    {
        std::cout << array[i] << " ";
    }

    return 0;
}