package net.iridescentsoftware.jnapple.appkit;

public class NSAlert {
    public enum NSModalResponse {
        OK(1),
        Cancel(0),
        Continue(-1002),
        Stop(-1000),
        Abort(-1001),
        FirstButtonReturn(1000),
        SecondButtonReturn(1001),
        ThirdButtonReturn(1002);

        int value;

        NSModalResponse(int value) {
            this.value = value;
        }

        public static NSModalResponse from(int value) {
            for (var response : values()) {
                if (response.value != value) continue;
                return response;
            }

            return null;
        }
    }
}
