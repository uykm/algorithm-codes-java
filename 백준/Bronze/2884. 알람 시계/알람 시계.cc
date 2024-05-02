#include <iostream>
using namespace std;

int main()
{
    int h, m;
    cin >> h >> m;
    if(m<45)
    {
        m += 15;
        if(h==0)
            h = 23;
        else if(h>0)
            h-=1;
    }
    else if(m>=45)
        m-=45;
    cout << h << " " << m;
}