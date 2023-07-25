import os

num_prob = 0
num_solution = 0
# for root, dirs, files in os.walk("../src/"):
#     # file = (root, dirs, files)
#     if "java" in files:
#         print(files)
#     # print(type(files))
#     if len(root.split("/")) == 3:
#         # if current directory is month
#         num_prob += len(dirs)
#
#     if len(root.split("/")) == 4:
#         # if current directory is problem
#         solutions = list(filter(lambda x: not x.endswith(".md"), files))
#         num_solution += len(solutions)
#
# print(num_prob, num_solution)


items = []

def print_files_in_dir(root_dir, prefix):
    files = os.listdir(root_dir)
    for file in files:
        path = os.path.join(root_dir, file)
        print(prefix + path)
        items.append(prefix + path)
        # if os.path.isdir(path):
        #     print_files_in_dir(path, prefix + "   ")

def file_write(items):
    f = open("새로운파일.txt", 'w')
    print(items)
    for item in items:
        f.writelines((str(item)))
        f.write('\n')
    f.close()

if __name__ == "__main__":
    root_dir = "../src/"
    print_files_in_dir(root_dir,"")
    file_write(items)

