import os
from operator import itemgetter, attrgetter

title_project = "# EveryDay - Practice"

class Problem:
    def __init__(self,id, week, day, filename, address):
        self.id =id
        self.week = week
        self.day = day
        self.filename = filename
        self.address = address
    def get_week(self):
        return self.week
    def get_day(self):
        return self.day
    def get_filename(self):
        return self.filename
    def __str__(self) -> str:
        return " | " + self.week + " | " + self.day + " | [" + self.filename + "](" + self.address + ")"  + "|\n"


def print_files_in_dir(root_dir, prefix ,problems):
    value = 1
    try:
        for (root, dirs, files) in os.walk(root_dir):
            for filename in files:
                ext = os.path.splitext(filename)[-1]
                if ext == '.java':
                    print("%s %s" % (root, filename))
                    split_dir = root.split("/")
                    address = root.replace("../","")
                    address += "/"+filename
                    if len(split_dir) >= 4:
                        week = str(split_dir[2])
                        day = str(split_dir[3])
                        filename = str(filename)
                        if week and day and filename:
                            problems.append(Problem(str(value),week,day,filename,address))
                            value += 1
    except PermissionError:
        pass





def make_info_data(problems):
    info = f"| # | week | day | problem |\n| ------------- | ------------- | ------------- | ------------- |\n"
    for index in range( 0, len(problems)):
        temp = f"| {index} {problems[index]}"
        info += temp

    info += """"""
    return info


if __name__ == "__main__":
    problems = []
    personal_dir = "../src/"
    print_files_in_dir(personal_dir, "",problems)
    projects = sorted(problems, key=attrgetter('week','day'),reverse=False)
    for problem in projects:
        print(problem)
    
    info = make_info_data(projects)

    with open("../README.md", 'w', encoding='utf-8') as f:
        f.write(title_project + "\n")
        f.write(info)
        f.close()
