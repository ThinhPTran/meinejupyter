data_to_print = ['cat', 'dog', 'fish']
printed_data = []

def print_object(to_print, printed):
	while to_print:
		cur = to_print.pop()
		printed.append(cur)

print("Before")
print(data_to_print)
print(printed_data)
print("After")
print_object(data_to_print, printed_data)
print(data_to_print)
print(printed_data)

