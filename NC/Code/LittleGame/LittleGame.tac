Num: cookies = 0
Num: cookiesProKlick = 1

Room START {
    Loop: true {
        Input:
        If: [{"Hallo"}] {
            NumDec: cookies = cookies + cookiesProKlick
            Say: Du hast 'cookies' Cookies
        } Else: {
            Say: Du benutzt die falsche Taste
        }
    }
}