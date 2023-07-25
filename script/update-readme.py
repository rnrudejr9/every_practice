import os


title_project = "# EveryDay - Practice"

class Problem:
    def __init__(self,id, week, day, filename):
        self.id =id
        self.week = week
        self.day = day
        self.filename = filename
    def get_week(self):
        return self.week
    def get_day(self):
        return self.day
    def get_filename(self):
        return self.filename
    def __str__(self) -> str:
        return " | " + self.id + " | " + self.week + " | " + self.day + " | " + self.filename + " |\n"


def print_files_in_dir(root_dir, prefix ,problems):
    value = 1
    try:
        for (root, dirs, files) in os.walk(root_dir):
            for filename in files:
                ext = os.path.splitext(filename)[-1]
                if ext == '.java':
                    print("%s %s" % (root, filename))
                    split_dir = root.split("/")
                    if len(split_dir) >= 4:
                        week = str(split_dir[2])
                        day = str(split_dir[3])
                        filename = str(filename)
                        if week and day and filename:
                            problems.append(Problem(str(value),week,day,filename))
                            value += 1
    except PermissionError:
        pass





def make_info_data(problems):
    info = f"| # | week | day | problem |\n| ------------- | ------------- | ------------- | ------------- |\n"
    for problem in problems:
        temp = f"{problem}"
        info += temp

    info += """"""
    return info


if __name__ == "__main__":
    problems = []
    personal_dir = "../src/"
    print_files_in_dir(personal_dir, "",problems)
    sorted(problems, key=lambda x: x.week)
    info = make_info_data(problems)

    with open("../README.md", 'w', encoding='utf-8') as f:
        f.write(title_project + "\n")
        f.write(info)
        f.close()
