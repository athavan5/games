from random import randint

def intro_game():
    start = True
    while start:
        print("Welcome to the Elevens Card Game\nHow To Play:\n")
        print("Press 2 + enter to Match up number pairs that add up to 11 OR\n")
        print("Press 3 + enter to Find any J-Q-K combinations to score points!\n")
        print("Number Format:\n")
        print("1 2 3\n4 5 6\n7 8 9")

        key = input("Press A + enter to start\n")
        while key != "A":
            key = input("Press A + enter to start\n")
        start = False
    print("\n")

def point_system(strCard):
    if strCard == "AD" or strCard == "AC" or strCard == "AH" or strCard == "AS":
        return 1
    elif strCard == "2D" or strCard == "2C" or strCard == "2H" or strCard == "2S":
        return 2
    elif strCard == "3D" or strCard == "3C" or strCard == "3H" or strCard == "3S":
        return 3
    elif strCard == "4D" or strCard == "4C" or strCard == "4H" or strCard == "4S":
        return 4
    elif strCard == "5D" or strCard == "5C" or strCard == "5H" or strCard == "5S":
        return 5
    elif strCard == "6D" or strCard == "6C" or strCard == "6H" or strCard == "6S":
        return 6
    elif strCard == "7D" or strCard == "7C" or strCard == "7H" or strCard == "7S":
        return 7
    elif strCard == "8D" or strCard == "8C" or strCard == "8H" or strCard == "8S":
        return 8
    elif strCard == "9D" or strCard == "9C" or strCard == "9H" or strCard == "9S":
        return 9
    elif strCard == "10D" or strCard == "10C" or strCard == "10H" or strCard == "10S":
        return 10

    return 0

def is_11_possible(arr):

    for i in range(len(arr)):
        for j in range(1, len(arr)):
            if point_system(arr[i]) + point_system(arr[j]) == 11:
                return True

    for a in range(len(arr)):
        for b in range(1, len(arr)):
            for c in range(2, len(arr)):
                s1 = arr[a]
                s2 = arr[b]
                s3 = arr[c]

                if s1[:1] == "J" and s2[:1] == "Q" and s3[:1] == "K":
                    return True
                elif s1[:1] == "J" and s2[:1] == "K" and s3[:1] == "Q":
                    return True
                elif s1[:1] == "Q" and s2[:1] == "J" and s3[:1] == "K":
                    return True
                elif s1[:1] == "Q" and s2[:1]== "K" and s3[:1] == "J":
                    return True
                elif s1[:1] == "K" and s2[:1] == "Q" and s3[:1] == "J":
                    return True
                elif s1[:1] == "K" and s2[:1] == "J" and s3[:1] == "Q":
                    return True


suit = ["D","C","H","S"]
face = ["A","2","3","4","5","6","7","8","9","10","J","Q","K"]

deck = []
for num in range(len(face)):
    for num_2 in range(len(suit)):
        deck.append(face[num]+suit[num_2])

game_list = []
score = 0
while len(game_list) < 9:
    index = randint(0,len(deck)-1)
    if deck[index] not in game_list:
        game_list.append(deck[index])

continued = len(game_list) > 0 and is_11_possible(game_list)
intro_game()

while (continued):

    print("------------------------------\n")
    print(f"Remaining Deck:\n{deck}\n")
    print("Press 2 + enter to Match up number pairs that add up to 11 OR\n")
    print("Press 3 + enter to Find any J-Q-K combinations to score points!\n")
    print(f"Score: {score}")
    print("\nNumber Format:\n1 2 3\n4 5 6\n7 8 9\n")
    print("----------------")
    print(f"| {game_list[0]} | {game_list[1]} | {game_list[2]} |")
    print("----------------")
    print(f"| {game_list[3]} | {game_list[4]} | {game_list[5]} |")
    print("----------------")
    print(f"| {game_list[6]} | {game_list[7]} | {game_list[8]} |")
    print("----------------")

    isNum = int(input("2 or 3 numbers?\n"))
    if isNum == 2:
        print("Please give two numbers.")
        a = int(input("First number: "))
        b = int(input("\nSecond number: "))
        while (a > 9 or a < 1 or b > 9 or b < 1):
            choice_sec = input("Please give two number positions.")
            a = int(input("First number: "))
            b = int(input("\nSecond number: "))

        if (point_system(game_list[a-1]) + point_system(game_list[b-1]) == 11):
            x = game_list[a-1]
            y = game_list[b-1]

            game_list.remove(game_list[a-1])
            game_list.insert(a-1, " ")

            game_list.remove(game_list[b-1])
            game_list.insert(b-1, " ")

            deck.remove(x)
            deck.remove(y)

            index_a = randint(0, len(deck)-1)
            while (deck[index_a] in game_list):
                index_a = randint(0, len(deck)-1)

            index_b = randint(0, len(deck)-1)
            while (deck[index_b] in game_list) or (deck[index_b] == deck[index_a]):
                index_b = randint(0, len(deck)-1)

            game_list.insert(a-1, deck[index_a])
            game_list.remove(" ")
            game_list.insert(b-1, deck[index_b])
            game_list.remove(" ")
            score+=1
    elif isNum == 3:
        print("Please give three numbers.")
        a = int(input("First number: "))
        b = int(input("\nSecond number: "))
        c = int(input("\nThird number: "))
        while (a > 9 or a < 1 or b > 9 or b < 1):
            choice_sec = input("Please give three number positions.")
            a = int(input("First number: "))
            b = int(input("\nSecond number: "))
            c = int(input("\nThird number: "))
        if (game_list[a-1][:1] == "J" and game_list[b-1][:1] == "Q"\
            and game_list[c-1][:1] == "K") or (game_list[a-1][:1] == "J"\
            and game_list[b-1][:1] == "K" and game_list[c-1][:1] == "Q")\
            or (game_list[a-1][:1] == "Q" and game_list[b-1][:1] == "J"\
            and game_list[c-1][:1] == "K") or (game_list[a-1][:1] == "Q"\
            and game_list[b-1][:1] == "K" and game_list[c-1][:1] == "J")\
            or (game_list[a-1][:1] == "K" and game_list[b-1][:1] == "Q"\
            and game_list[c-1][:1] == "J") or (game_list[a-1][:1] == "K"\
            and game_list[b-1][:1] == "J" and game_list[c-1][:1] == "Q"):

            x = game_list[a-1]
            y = game_list[b-1]
            z = game_list[c-1]

            game_list.remove(game_list[a-1])
            game_list.insert(a-1, " ")

            game_list.remove(game_list[b-1])
            game_list.insert(b-1, " ")

            game_list.remove(game_list[c-1])
            game_list.insert(c-1, " ")

            deck.remove(x)
            deck.remove(y)
            deck.remove(z)

            index_a = randint(0, len(deck)-1)
            while (deck[index_a] in game_list):
                index_a = randint(0, len(deck)-1)

            index_b = randint(0, len(deck)-1)
            while (deck[index_b] in game_list) or (deck[index_b] == deck[index_a]):
                index_b = randint(0, len(deck)-1)

            index_c = randint(0, len(deck)-1)
            while (deck[index_c] in game_list) or (deck[index_c] == deck[index_a])\
                or (deck[index_c] == deck[index_b]):
                index_c = randint(0, len(deck)-1)

            game_list.insert(a-1, deck[index_a])
            game_list.remove(" ")
            game_list.insert(b-1, deck[index_b])
            game_list.remove(" ")
            game_list.insert(c-1, deck[index_c])
            game_list.remove(" ")
            score+=1


    if len(deck) == 9 and len(game_list) > 0:
        print("YOU WIN")
        break

    continued = len(game_list) > 0 and is_11_possible(game_list)

if len(deck) > 9:
    print("-----------------------------------------")
    print(f"Score: {score}\n")
    print(game_list[0], game_list[1], game_list[2])
    print(game_list[3], game_list[4], game_list[5])
    print(game_list[6], game_list[7], game_list[8])
    print("YOU LOSE")
