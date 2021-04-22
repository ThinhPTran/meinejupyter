unprinted_designs = ['cat', 'dog', 'fish']
printed = []

def print_object(unprinted, printed):
	while unprinted:	
		cur = unprinted.pop()
		printed.append(cur)

print("Before")
print(unprinted_designs)
print(printed)
print_object(unprinted_designs[:], printed)
print("After")
print(unprinted_designs)
print(printed)

