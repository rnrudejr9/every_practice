from selenium import webdriver
from time import sleep
from selenium.webdriver.common.by import By

try:
    driver = webdriver.Chrome()
    url = 'https://edu.ssafy.com/'
    driver.get(url)
    sleep(3)

    driver.find_element(By.ID,"userId").send_keys(myId);
    sleep(1)
    driver.find_element(By.ID,"userPwd").send_keys(pw);
    sleep(3)
    driver.find_element(By.CSS_SELECTOR,"#wrap > div > div > div.section > form > div > div.field-set.log-in > div.form-btn > a").click();
    attribute = driver.find_element(By.CSS_SELECTOR,
                                    "#wrap > div.container.main-container > div.content > section.main-page.sec1 > div > div.col-md.n1 > div > div.btns > div.state.inRoomEnd > span");
    get_attribute = attribute.get_attribute('innerHTML')

    print(get_attribute);
    find = get_attribute.find("정상 출석")
    print(find);
    if find == -1:
        print("출석해야해!");

    sleep(5)
except:
    print("hello")
