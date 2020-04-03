def answer(t, ans, lastone):
    if lastone != '' and t != '':
        if int(lastone) > int(t[0]):
            for i in range(int(lastone)-int(t[0])):
                ans = ans + ')'
    if t == '':
        for i in range(int(lastone)):
            ans = ans + ')'
        return ans
    if int(t[0]) == 0:
        return answer(t[1:], ans + t[0], t[0])
    if int(t[0]) == 1:
        if lastone != '':
            if int(lastone) == 0:
                ans = ans + '(' + t[0]
            else:
                ans = ans + t[0]
        else:
            ans = ans + '(' + t[0]
        return answer(t[1:], ans, t[0])
    if int(t[0]) > 1:
        if lastone != '':
            for i in range(int(t[0]) - int(lastone)):
                ans = ans + '('
            ans = ans + t[0]
        else:
            for i in range(int(t[0])):
                ans = ans + '('
            ans = ans + t[0]
        return answer(t[1:], ans, t[0])


t = int(input())
for m in range(0, t):
    k = input()
    print('Case #{}: {}'.format(m + 1, answer(k, '', '')))
