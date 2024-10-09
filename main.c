#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>
#include <windows.h>

void clipboardCopy(char* generatedPassword);

int main()
{
    char numbers[10] = {'0','1','2','3','4','5','6','7','8','9'};
    char lowercaseLetters[26] = {"abcdefghijklmnopqrstuvwxyz"};
    char uppercaseLetters[26] = {"ABCDEFGHIJKLMNOPQRSTUVWXYZ"};
    char symbols[7] = {'!','@','#','$','%','&','*'};
    char generatedPassword[17];

    char *allCharacters[4] = {numbers,lowercaseLetters,uppercaseLetters,symbols};

    int i,x,y,j;

    srand(time(0));

    printf("welcome to Rhett's Password Generator\n");

    printf("here is your password:\n\n");


    for ( i = 0; i < 16; i++ )
    {
        x = rand() % 4;

        switch(x)
        {
            case 0:
                y = rand() % 10;
                break;
            case 1:
                y = rand() % 26;
                break;
            case 2:
                y = rand() % 26;
                break;
            case 3:
                y = rand() % 7;
                break;
            default:
                y = 0;
        }
        generatedPassword[i] = allCharacters[x][y];
        printf("%c",generatedPassword[i]);
    }
    generatedPassword[16] = '\0';

    printf("\n\nCoded by:\nRhett Smithgall\n");
    printf("Press any key to continue\n");

    clipboardCopy(generatedPassword);

    int a;
    scanf("%d", &a);
}

void clipboardCopy(char* str)
{
    const char* output = str;
    const size_t len = strlen(output) + 1;
    HGLOBAL hMem =  GlobalAlloc(GMEM_MOVEABLE, len);
    memcpy(GlobalLock(hMem), output, len);
    GlobalUnlock(hMem);
    OpenClipboard(0);
    EmptyClipboard();
    SetClipboardData(CF_TEXT, hMem);
    CloseClipboard();
}
