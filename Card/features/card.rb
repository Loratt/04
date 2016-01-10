# require 'byebug'
require 'date'
require 'rubygems'
require 'couchrest'
FORMAT = "%Y-%m-%d"
filename = "My first file"
@auth_token = nil
 


Given /I can see keyboard/ do 
     input_method = `#{default_device.adb_command} shell dumpsys input_method`.force_encoding('UTF-8')
        shown = input_method.each_line.grep(/mInputShown\s*=\s*(.*)/){$1}.first.chomp

        if shown == "true"
          true
        elsif shown == "false"
          false
        else
          raise "Could not detect keyboard visibility. '#{shown}'"
        end
end

And /Previous button should be disabled/ do
     reg = query"Button text:'Previous'", 'enabled' 
         if reg == [false]
           true
		 else
		   fail( "Button Previous is enabled" )
         end  
end

And /Next button should be disabled/ do
     reg = query"Button text:'Next'", 'enabled' 
         if reg == [false]
           true
		 else
		   fail( "Button Next is enabled" )
         end  
end

Then /I enter code "(\d+)"$/ do |text|
     enter_text("android.widget.EditText id:'edit_text'", text)
end

And /Next button should be enabled/ do
     reg = query"Button text:'Next'", 'enabled' 
         if reg == [true]
           true
		 else
		   fail( "Button Next isn't enabled" )
         end  
end

And /I can see visa card icon/ do 
     et = query"android.widget.ImageView tag:'2'"
	 if et == []
     fail( "Icon of the card hasn't changed" )
  end
end

Then /I press the button Next/ do
     touch "button text:'Next'"
end

And /Previous button should be enabled/ do
     reg = query"Button text:'Previous'", 'enabled' 
         if reg == [true]
           true
		 else
		   fail( "Button Next isn't enabled" )
         end  
end

Then /I enter data "(\d+)"$/ do |text|
     enter_text("android.widget.EditText id:'data'", text)
end

And /I can see the back side of the card icon/ do 
     et = query"android.widget.ImageView tag:'3'"
	 if et == []
     fail( "Icon of the card hasn't changed" )
  end
end

Then /I enter CVV code "(\d+)"$/ do |text|
     enter_text("android.widget.EditText id:'cvv'", text)
end

Then /I can see image/ do
     reg = query"* id:'image'", :getTag
     puts reg
end

And /OK button should be enabled/ do
     reg = query"Button text:'OK'", 'enabled' 
         if reg == [true]
           true
		 else
		   fail( "Button OK isn't enabled" )
         end  
end

Then /I press the button OK/ do
     touch "button text:'OK'"
end


And /OK button renamed to Processing.../ do
	 query"Button text:'Processing...'"
end


And /Processing... button should be disabled/ do
     reg = query"Button text:'Processing...'", 'enabled' 
         if reg == [false]
           true
		 else
		   fail( "Button Processing... is enabled" )
        end  
end


Then /I create a new record in the database/ do
     server = CouchRest.new           
     db = server.database('tornado-couch-testdb')  
     db.save_doc('_id' => 'doc', 'type' => 'user')
     doc = db.get('doc')
     db.delete_doc(doc)
end


And /Processing... button renamed to Confirmed/ do
	 query"Button text:'Confirmed'"
end
