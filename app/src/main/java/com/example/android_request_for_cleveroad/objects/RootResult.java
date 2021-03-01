package com.example.android_request_for_cleveroad.objects;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RootResult {
        @SerializedName("results")
        private List<User> users;

        private Info info;


        public List<User> getUsers() {
            return users;
        }

        public void setUsers(List<User> users) {
            this.users = users;
        }

        public Info getInfo() {
            return info;
        }

        public void setInfo(Info info) {
            this.info = info;
        }

}
