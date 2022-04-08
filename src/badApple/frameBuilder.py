import cv2


res_dir = "res"
canvas_width = 80
canvas_height = 40

cap = cv2.VideoCapture(res_dir + "/badapple.mp4")

char_list = [' ', '`', '\'', '.', '-', '_', ',', '"', ':', '!', '=', '~', ';', '>', '+', '<', '^', '*', 'r', ')', '(', '?', '|', '/', '\\', 'v', 'x', ']', '[', 'i', 'L', '7', 'Y', '}', '{', 'T', 'l', '1', 'u', 'n', 'c', 'V', 'y', 'w', 'J', '2', 'k', 'z', 't', 'C', 'j', 'o', 'X', 'F', 'I', 'h', '4', 'U', 's', 'e', 'm', 'f', 'K', 'a', '3', 'P', 'H', 'G', 'W', 'A', 'q', 'p', 'S', '%', '5', 'M', 'Z', 'b', 'd', 'O', 'N', '6', '9', 'R', 'E', 'D', '0', '&', '$', 'g', '8', 'Q', 'B', '#', '@'];

with open(res_dir + "/badapple.dat", "a+") as f:
    while(cap.isOpened()):

        frame_exists, frame = cap.read()
        if not frame_exists:
            break

        frame = cv2.resize(
                frame, 
                (canvas_width, canvas_height)
        )

        # grayscale the frame
        gray_frame = cv2.cvtColor(frame, cv2.COLOR_BGR2GRAY)

        out = ""
        for line in gray_frame:
            for pixel in line:
                out += char_list[
                    int(
                        pixel / 255 * (len(char_list) - 1)
                    )
                ]
            out += "\n"
        f.write(out)
