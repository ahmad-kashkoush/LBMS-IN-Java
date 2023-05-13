

 public   class Login {
        String Email;
        String Password;
        String Backup;

        public void setEmail(String s) {
            Email = s;
        }

        public void setBackup(String s) {
            Backup = s;
        }

        public void setPassword(String p) {
            Password = p;
        }

        public String getEmail() {
            return Email;
        }

        public String  getPassword() {
            return Password;
        }

        public String getBackup() {
            return Backup;
        }

        public Login(String s, String  p, String backup) {
            setEmail(s);
            setPassword(p);
            setBackup( backup );
        }
    }


