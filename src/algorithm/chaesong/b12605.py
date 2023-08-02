N = int(input())
words = []
for i in range(N):
    words.append(input().split())
#[['this, 'is', 'a', 'test'], ['footbar'], ['all', 'your', 'base']]
#입력값 끝
for i in range(N):
    reversed_word = list(reversed(words[i]))
    num = i + 1
    print(f"Case #{num}:", *reversed_word)

